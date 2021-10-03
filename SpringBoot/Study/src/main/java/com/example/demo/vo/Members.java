package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data				//롬복에서 getter setter ToString을 한방에 처리해줌
@AllArgsConstructor	//모든 필드값을 파라미터로 받는 생성자를 만듬
@NoArgsConstructor 	//파라미터가없는 기본생성자
@Builder //요즘 대세인 Builder패턴을 위해 
public class Members {
	private Integer memberId;
	private String memberName;
	private String memberAge;
	private String memberAdd;
	private String memberImg;
	private Integer memberGender;
}
