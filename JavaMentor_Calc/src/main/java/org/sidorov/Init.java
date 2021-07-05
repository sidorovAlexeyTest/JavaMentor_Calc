package org.sidorov;

import org.sidorov.input.Input;
import org.sidorov.input.InputFromConsole;
import org.sidorov.output.Output;
import org.sidorov.output.OutputToConsole;
import org.sidorov.processing.ProcessingAbstract;
import org.sidorov.processing.ProcessingCalculate;
import org.sidorov.processor.ProcessorCalculate;
import org.sidorov.processor.ProcessorInterface;

public class Init {
    public static void main(String[] args) {
        ProcessorInterface processor = new ProcessorCalculate();
        Input input = new InputFromConsole();
        Output output = new OutputToConsole();

        ProcessingAbstract processing = new ProcessingCalculate();
        processing.setIO(input, output);
        processing.setProcessor(processor);
        processing.processing();
    }
}
