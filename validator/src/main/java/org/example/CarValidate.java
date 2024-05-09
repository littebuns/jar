package org.example;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@Slf4j
@Validated
public class CarValidate {

    public static void main(String[] args) throws IOException {

        File file = ResourceUtils.getFile("classpath:test.xlsx");
        System.out.println(file.exists());
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        EasyExcel.read(file, Car.class, new ReadListener<Car>() {

            @Override
            public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
                System.out.println(headMap);
                ReadListener.super.invokeHead(headMap, context);
            }

            @Override
            public void invoke(Car car, AnalysisContext context) {
                Set<ConstraintViolation<Car>> violations = validator.validate(car);
                for (ConstraintViolation<Car> violation : violations) {
                    System.out.println(violation.getMessage());
                }

            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                System.out.println(context);
            }
        }).sheet().doRead();



//        // 这里 只要，然后读取第一个sheet 同步读取会自动finish
//        EasyExcel.read(file,Car.class, new NoModelDataListener()).sheet().doRead();

    }


}
