//상수 
//변하지 않는 것
// const를 사용한다
//상수는 대문자로 하는것이 관례
const PI=3.14;
let radius;

//pi = 3; //에러발생

function calculateArea(){
    return PI*radius*radius;
}

//반지름에 따른 원의 넓이 출력
function printArea(){
    return `반지름이 ${radius}일때, 원의 넓이는 ${calculateArea()}`;
}
radius =4;
console.log(printArea());
radius =7;
console.log(printArea());
radius =8;
console.log(printArea());

//함수변수 문제
/*코드잇 마을에서는 대중교통을 이용할 때, 교통카드를 단말기에 태그하면 "삑!"하고 소리가 납니다.
그런데 항상 "삑!"소리만 나는 게 아니라 상황에 따라서 청소년의 경우에는 "삑삑!", 승차권이 제대로 찍히지 않을 땐 "삑삑삑!", 그리고 환승을 할 때는 "환승입니다." 라는 소리도 나는데요.
 */
// 아래에 adultTag, teenagerTag, errorTag, transferTag라는 변수들을 작성해 주세요.
let adultTag ="삑!";
let teenagerTag="삑삑!";
let errorTag = "삑삑삑!";
let transferTag ="환승입니다.";

// 아래에 tagCase파라미터를 가지는 tagNotification 함수를 작성해 주세요.
function tagNotification(x){
  console.log(x);
}

// 테스트 코드
tagNotification(adultTag);
tagNotification(teenagerTag);
tagNotification(transferTag);
tagNotification(errorTag);
tagNotification(adultTag);