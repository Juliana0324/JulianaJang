function factorial(n) {
    let result = 1;
      for(let i=2; i<=n;i++){
        result*=i;
      }
      return result;
  }
  
  // 테스트 코드
  console.log(factorial(12));
  console.log(factorial(6));
  console.log(factorial(3));
  console.log(factorial(0));