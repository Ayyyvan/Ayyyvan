const process = require('process');
const hasher = require('crypto-js/hmac-sha256');
const encoder = require('crypto-js/enc-hex');
const {sha3_256} = require('js-sha3');
var Promise = require("bluebird");
const readline = require('readline-sync');
const invalidMovesError = `Something wrong! Check all the rules and launch it again! \n1. Number of moves must be odd and > 1\n2. All moves must be unique\nTry 'node game.js 1 2 3' or 'node game.js rock paper scissors lizard Spock'`

class HmacGenerator {

    static getKey() {
        return sha3_256(Math.random().toString());
    }

    static getHmac(message, key) {
        return encoder.stringify(hasher(message, key));
    }
}

class RuleTablePrinter {
    static printHelpTable(moves, results){
        var results = results
        var moves = moves
        var winnerMap = {}
        for(var i = 0; i< moves.length; i++){
            var computerMoves = {}
            for(var j = 0; j < moves.length; j++){
                computerMoves['Computer ' + moves[j]] = results[i][j]
            }
            winnerMap['Your '+ moves[i]] = computerMoves
        }
    console.table(winnerMap)
    }
}

class RockPaperScissors {

    results = [];
    
    constructor(moves){
        this.moves = moves
        this.createWinnerArray()
    }

    startGame(){
        var key = HmacGenerator.getKey()
        var computerMoveIndex = this.makeComputerMove()
        console.log('HMAC: ' + HmacGenerator.getHmac(this.moves[computerMoveIndex], key))
        var userInput = this.makeUserMove()
        var result = this.results[userInput][computerMoveIndex]
        console.log('Your move: ' + this.moves[userInput] +
                    '\nComputer move: ' + this.moves[computerMoveIndex] + '\n' +
                     result + 
                     '\nKey: ' + key)
    }
    
    createWinnerArray() {
        
        var half = parseInt(this.moves.length / 2)
        for(var i = 0; i < this.moves.length; i++){
            this.results[i] = Array(this.moves.length).fill('Lose')
            this.results[i][i] = 'Draw'

            var start = i+1
            var end = start + half
        
            this.results[i].fill('Win', start, end)
            if(i > half){
                this.results[i].fill('Win', 0, half - (this.moves.length - start))
            }
        }
        return this.results
    }

    getMovesListMessage(){
        var movesList = 'Available moves:\n';
        for(var i = 0; i < this.moves.length; i++){
            movesList += i+1 + ' - ' + this.moves[i]+ '\n'
        }
        movesList += '0 - exit\n? - help\n'
        return movesList
    }

    makeComputerMove()
    {
        return this.getRandomInt(0, this.moves.length-1);
    }

    makeUserMove()
    {
        var userInput = readline.question(this.getMovesListMessage())
        if(userInput == '?'){
            RuleTablePrinter.printHelpTable(this.moves, this.results)
        }
        else{
            userInput = Number(userInput)
            if(userInput == 0){
                process.exit()
            }
            else if(this.moves[userInput-1]){
                return userInput - 1
            }
            else{
                console.log('Wrong Input');
            }
        } 
        return this.makeUserMove()
    }

    getRandomInt(min, max) {
        min = Math.ceil(min);
        max = Math.floor(max);
        return Math.floor(Math.random() * (max - min + 1)) + min;
      }
    
}

function isMovesValid(moves)
{
    var movesSet = new Set(moves)
    if(moves.length % 2 == 0 || moves.length <= 1 || moves.length != movesSet.size)
    {
        return false
    }
    return true
}

function game(moves)
{
    if(!isMovesValid(moves)) {
        Promise.try(console.log(invalidMovesError)).then(process.exit())
    }
    game = new RockPaperScissors(moves)
    game.startGame()
}
game(process.argv.slice(2))