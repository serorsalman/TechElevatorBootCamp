function createObject() {
    const PERSON = {
        firstName: "Minnie",
        lastName: "Mouse",
        age: 29
    };
    console.log(PERSON);
    console.table(PERSON);
    console.log(PERSON.firstName);

}

function constDemo(variable) {
    const CONSTANT = 6;
    console.log(variable + CONSTANT);
}

function addNumber(number1, number2 = 10, number3) {
    return number1 + number2;
}

function printMessage(times, message) {
    if (message === undefined) {
        message = "Hello there";
    }
    for (let i = 0; i < times; i++) {
        console.log(message);
    }
}

function printMessage2(times, message = 'Hello there') {
    for (let i = 0; i < times; i++) {
        console.log(message);
    }
}


function longestString() {
    let longest = '';
    for (let i = 0; i < arguments.length; i++) {
        if (arguments[i].length > longest.length) {
            longest = arguments[i];
        }
    }
    return longest;
}
/**
 * takes all values passed in and determines
 * if one is a number.  If it is a number, we
 * will sum all the numbers.
 * @returns 
 */
function addAllNumbers() {
    let sum = 0;
    for (let i = 0; i < arguments.length; i++) {
        // console.log(typeof arguments[i]); // string of datatype
        if ((typeof arguments[i]) === 'number') {
            sum += arguments[i];
        }
    }
    const num = 5;
    //typeof returns the datatype
    // returns it as a string
    console.log(typeof num); // number
    return sum;
}

function multiplyByTwo(num) {
    console.log(num * 2);
}

function callMultiplyByTwo() {
    multiplyByTwo(4);

    let ary = [2, 7, 9];
    for (let i = 0; i < ary.length; i++) {
        multiplyByTwo(ary[i]);
    }

    // num is referring to each element in ary
    // we are passing that num value to the function
    // multiplyByTwo
    ary.forEach((num) => multiplyByTwo(num));

    ary.forEach((num) => {
        console.log(num * 2);
    });
    // above in java would be
    // for (int num : ary)

    let strAry = ['hi', 'bye'];
    strAry.forEach((element) => {
        console.log(element);
    });

    let multiply = (x, y) => {
        return x * y;
    }
    console.log(multiply(3, 5));
}