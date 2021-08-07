function 함수이름(파라미터, 파라미터){
  console.log(파라미터)
}

함수이름(값)

//ex
function printSum(a, b){
  console.log(a+b);
};

//함수호출
printSum(10,5);



function introduce(name, birth, nationality, job){
  console.log("안녕하세요! 반갑습니다.");
  console.log("제 이름은 "+name+"입니다.");
  console.log("생년월일은 "+birth+"이고,");
  console.log("국적은 "+nationality+"입니다");
  console.log("직업은 "+job+"입니다.");
  console.log("잘부탁드립니다.");
};

introduce('코드잇', '17.05.18', '한국', '프로그래밍 강사');

/**
실행결과

안녕하세요! 반갑습니다.
제 이름은 코드잇입니다.
생년월일은 17.05.18이고,
국적은 한국입니다
직업은 프로그래밍 강사입니다.
잘부탁드립니다.
**/