package it.unibo.bmbman.controller;
/**
 * implementation of OptionMenuController interface.
 */
public class OptionMenuControllerImpl implements OptionsMenuController {
    /**
     * .
     */
    @Override
    public void setOptionSelected(final OptionsList optionselected) {
        switch (optionselected) {
            case SOUND:
                // do something
                break;
            default:
                break;
        }

    }

}
