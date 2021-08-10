//typeof: 자료형 출력 
console.log(typeof 101);  //#number
console.log(typeof 'Codeit'); //String
console.log(typeof true);   // Boolean

console.log(typeof 1);    //number
console.log(typeof 1.0);  //number
console.log(typeof '1');  //String
console.log(typeof "1");  //string

let name="Codeit";
function sayHello(){
  console.log('Hello');
};

console.log(typeof name);   //string
console.log(typeof sayHello); //function

console.log(typeof 'Hello'+ 'Codeit');   //stringCodeit
console.log(typeof 8-3); //NaN
                        //Not a Number

console.log(typeof (8-3));
//괄호 사용하기! 

//형변환 
// 숫자-> 문자
let x = 123;
console.log(x);
console.log(String(x));
console.log(typeof x);
console.log(typeof String(x));

//Boolean=> 문자
let y= true;
console.log(y);
//y를 false로 변경했을때 0출력, true=1
console.log(String(y));
console.log(typeof y);
console.log(typeof String(y));

let z= '문자';
console.log(z);
console.log(Boolean(z));
//Boolean으로 변경시 true로 출력됨
console.log(typeof z);
console.log(typeof String(z));


console.log('4'-true);
// 3
//자동 형변환

console.log(4+'2'); //42 : +는 문자열을 연결한다
console.log(4+2);   
console.log(4 - true);
console.log(4*false);
console.log(4/'2');   //2
console.log('4' ** true);   //4
console.log(4 % 'two');   //NaN


//관계연산
console.log('two' >= 1);  //false
//'two'=> Nan 
//비교가 불가능한 경우 false

//=== : 주소값까지 같다!
console.log(1==='1');
//false
console.log(1=='1')
//true

