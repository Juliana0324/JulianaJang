//Scope = 범위,영역
let x=3;    //전역변수

function myFunction(){  //블록문 (Blockstatement)
    let y=5;//로컬변수 : 지역변수 (Local variable)
    console.log(y); //5출력 
    console.log(x); //3
}

myFunction();
console.log(y); //에러출력: 블록문 안에서만 사용가능합니다.
console.log(x);     //3출력
