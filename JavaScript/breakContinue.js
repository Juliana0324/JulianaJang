for(let i=1; i<=10; i++){
    if(i%2 ===0){
        continue;
    }
    console.log(i);
}

//홀수만 출력
//continue => 그부분만 건너뛴다

let i=1;
while(i<=10){
    if(i%2 ===0){
        i++;    //while은 자동 더해지는 것이 없기때문에 
        continue;
    }
    console.log(i);
    i++;
}

//while이용한 구구단
let i = 1;
while (i <= 9) {
  let j = 1;
  while (j <= 9) {
    console.log(`${i} * ${j} = ${i * j}`);
    j++;
  }
  i++;
}