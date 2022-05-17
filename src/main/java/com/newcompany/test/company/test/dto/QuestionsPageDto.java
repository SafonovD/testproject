package com.newcompany.test.company.test.dto;

import com.newcompany.test.company.test.model.Questions;
import lombok.Data;

import java.util.List;

@Data
public class QuestionsPageDto {

    private List<Questions> data;
    private int currentPage;
    private int totalPage;
    private boolean hasNext;
    private boolean hasPrevious;

}
