//메소드 
let greetings = {
    sayHello: function(name){
        console.log(`Hello ${name}!`);
    },

    sayHi: function(){
        console.log(`Hi!`);
    },

    sayBye: function(){
        console.log(`Bye!`);

    }
};

greetings.sayHello(`Codeit!`);

//대괄호사용법
greetings['sayHello'](`Codeit`);
//메소드는 고유한 동작으로써 함수를 정의할수 있음


let rectAgle={
    width: 30,
    height: 50,
    getArea: function(){
        return rectAgle.width * rectAgle.height;
    }
}

let triAngle = {
    width: 15,
    height: 40,
    getArea: function(){
        return triAngle.width * triAngle.height /2;
    }
}

