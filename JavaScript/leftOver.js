function calculateChange(payment, cost) {
    // 코드를 작성해 주세요.
    let leftOver = payment-cost ;
    
    function build(amount){
      const count = Math.floor(leftOver/amount);
      leftOver = leftOver-count * amount;
      console.log(`${amount}원 지폐: ${count.toFixed(0)}장`);
    }
    build(50000);
    build(10000);
    build(5000);
    build(1000);
  }
    
  // 테스트 코드
  calculateChange(100000, 33000);
  console.log('');
  calculateChange(500000, 378000);