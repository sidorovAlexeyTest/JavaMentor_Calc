package org.sidorov.processing;

import org.sidorov.input.Input;
import org.sidorov.output.Output;
import org.sidorov.processor.ProcessorInterface;

import java.util.List;

public interface ProcessingInterface {

    void setIO(Input input, Output output);

    void setProcessor(ProcessorInterface processor);

    boolean validation(List<String> list);

    List<String> preparing(String line) throws Exception;

    void processing();
}
