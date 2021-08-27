//숫자 표기법
console.log(25e5 === 2500000);
console.log(5.3e3 === 5300);
console.log(-6.1e8 === -610000000);

//16진법
let hex1= 0xff; //255
let hex2 = 0xFF; //255

//8진법
let octal = 0o377; //255;

//2진법
let binary = 0b11111111; //255

console.log(hex1);
console.log(hex2);
console.log(octal);
console.log(binary);

//Number
let myNumber = 0.3591;

//toFixed(0~100)
//소수점 아래 (number)값
console.log(myNumber.toFixed(3));

/* 주의!! 
 String 으로 받아줌
*/
console.log(typeof myNumber.toFixed(3));
//String

//형변환시켜주기
console.log(typeof Number(myNumber.toFixed(3)));

//출력결과 0.36
console.log(+myNumber.toFixed(2));



//Number
let myNumber2 = 255;

//toString
console.log(myNumber2.toString(2));
console.log(myNumber2.toString(8));

