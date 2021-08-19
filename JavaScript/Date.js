let myDate = new Date();

console.log(myDate);
//현재 시간 
//2021-08-19T06:30:24.834Z

let myDate = new Date(1000);
//1970-1월-1일 00:00:00

let Date = new Date('2017-05-18');

let myDate = new Date(YYYY, MM, DD, hh,mm,ss, ms);
let myDate1 = new Date(2020, 8, 19, 03,11,10, ms);


//Month는 0부터시작함으로 
let myDate2 = new Date(2020, 4, 19, 03,11,10, ms);
//==> 2020.5.19....

 
let myDate3 = new Date(2017,5,18,19,11,16);
console.log(myDate.getTime());
// getTime: myDate객체가 1970 1월 1일 00시... UTC부터 얼마나 지낫는지

let myDate4 = new Date(2017,5,18,19,11,16);
let today = new Date();

let timeDiff=myDate4.getTime() - today.getTime();

console.log(timeDiff+' 밀리초');
console.log(timeDiff+" 초");
console.log(timeDiff/1000/60+ ' 분');
console.log(timeDiff / 1000/60/60 +' 시간');




//문제 입사일 Dday
let today = new Date(2112, 8, 24);
let jaeSangStart = new Date(2109, 7, 1);

function workDayCalc(startDate) {
	// 여기에 코드를 작성해 주세요.
	let Date = today.getTime() - jaeSangStart.getTime();
	let dDay = Date/1000/60/60/24+1;
	console.log(`오늘은 입사한 지 ${dDay}일째 되는 날 입니다.`);
	
}

workDayCalc(jaeSangStart);