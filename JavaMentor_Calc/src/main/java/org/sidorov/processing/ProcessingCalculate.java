package org.sidorov.processing;

import org.sidorov.type.ConverterRomanArab;
import org.sidorov.type.TypeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ProcessingCalculate extends ProcessingAbstract {

    private TypeConverter typeExec;
    private String typeA;

    @Override
    public boolean validation(List<String> list) {
        super.validation(list);

        typeExec = new ConverterRomanArab();

        typeA = typeExec.getType(list.get(0));
        String typeB = typeExec.getType(list.get(2));

        if (!typeA.equals(typeB) || typeA.equals(TypeConverter.INCORRECT_TYPE)) {
            return false;
        }

        Pattern pattern = Pattern.compile("[+\\-\\*/]");

        return pattern.matcher(list.get(1)).matches();
    }

    @Override
    public List<String> preparing(String line) {
        List<String> list = Arrays.asList(line.split(" "));
        if (!validation(list)) {
            throw new UnsupportedOperationException("Incompatible symbols type");
        }
        List<String> operands = new ArrayList<>();

        if(!typeA.equals(TypeConverter.ARABIAN)){
            operands.add(typeExec.turnToArabian(list.get(0)));
            operands.add(list.get(1));
            operands.add(typeExec.turnToArabian(list.get(2)));
        }else {
            operands.addAll(list);
        }

        return operands;
    }

    @Override
    public void processing() {
        String line = input.getInfo();
        List<String> list = preparing(line);
        String[] operands = {list.get(0), list.get(1), list.get(2)};
        String result = processor.processing(operands);
        if(!typeA.equals(TypeConverter.ARABIAN)){
            if(Integer.parseInt(result) <= 0){
                throw new UnsupportedOperationException("There are no negative numbers or zero in roman numerics");
            }
            result = typeExec.turnToRevers(result);
        }
        output.send(result);
    }
}
