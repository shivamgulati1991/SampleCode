var test = require('unit.js');
var example = 'hello';
test.string(example);
test.assert(typeof example === 'string');
console.log(test.stats);