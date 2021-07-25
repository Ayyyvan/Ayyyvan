import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

public class Computer {
    private static final String HMAC_ALGO = "HmacSHA256";
    private List<String> moves;
    private int index;
    private String key;
    private String hmac;

    public Computer(List<String> moves){
        this.moves = moves;
    }

    public String getMove() {
        Random random = new Random();
        this.index = random.nextInt(moves.size());
        createHmac(moves.get(index));
        return moves.get(index);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length*2);
        for(byte b: bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private void createHmac (String move) {
        try{
            SecureRandom secureRandom = new SecureRandom();
            byte []bytes = new byte[16];
            secureRandom.nextBytes(bytes);

            Mac signer = Mac.getInstance(HMAC_ALGO);
            SecretKeySpec keySpec = new SecretKeySpec(bytes, HMAC_ALGO);
            signer.init(keySpec);

            byte[] digest = signer.doFinal(move.getBytes("utf-8"));
            key = bytesToHex(bytes);
            this.hmac = bytesToHex(digest);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public String getKey() {
        return key;
    }
    public String getHmac() {
        return hmac;
    }




}

