package org.example;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString
public class Car {

    @NotNull
    @ExcelProperty(value = "name", index = 0)
    private String name;

    @Max(value = 10)
    @ExcelProperty(value = "age", index = 1)
    private int age;

}
