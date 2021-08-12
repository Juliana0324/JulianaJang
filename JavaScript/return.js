function square(x){
    console.log('return 전');
    return x*x;
    console.log('return 후'); //dead code
}
console.log('함수 호출 전');
console.log(square(3));
console.log('함수 호출 후');
//함수 실행 중단

//console vs return
function getSquare(x){
    return x*x;
}

function printSquare(x){
    console.log(x*x);
}

printSquare(3); //출력: 9
getSquare(3);   //콘솔출력x
console.log(getSquare(3)); //9
console.log(printSquare(3));    //undefined

// 여기에 calculateRectangleArea 함수를 작성해 주세요.
function calculateRectangleArea(x,y){
    return x*y;
 }
 
 // 테스트 코드 
 // 사각형
 let area1 = calculateRectangleArea(3, 4); // 가로 3, 세로 4인 직사각형의 넓이 계산
 let area2 = calculateRectangleArea(5, 8); // 가로 5, 세로 8인 직사각형의 넓이 계산
 let area3 = calculateRectangleArea(7, 2); // 가로 7, 세로 2인 직사각형의 넓이 계산
 
 console.log(`Area1: ${area1}, Area2: ${area2}, Area3: ${area3}`);