package steps;

import io.cucumber.java.ru.И;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HarViewerSteps extends BaseSteps {
    
    @И("^открыть меню фильтров$")
    public void clickToLeftMenuStep() {
        apptest
                .getHarViewerPage()
                .openFilterMenu();
    }
}
