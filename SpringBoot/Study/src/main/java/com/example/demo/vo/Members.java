package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data				//�Һ����� getter setter ToString�� �ѹ濡 ó������
@AllArgsConstructor	//��� �ʵ尪�� �Ķ���ͷ� �޴� �����ڸ� ����
@NoArgsConstructor 	//�Ķ���Ͱ����� �⺻������
@Builder //���� �뼼�� Builder������ ���� 
public class Members {
	private Integer memberId;
	private String memberName;
	private String memberAge;
	private String memberAdd;
	private String memberImg;
	private Integer memberGender;
}
