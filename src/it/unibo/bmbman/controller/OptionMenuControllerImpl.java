package it.unibo.bmbman.controller;
/**
 * implementation of OptionMenuController interface.
 */
public class OptionMenuControllerImpl implements OptionsMenuController {
    private final SoundsController sc = new SoundsController();
    /**
     * {@inheritDoc}
     */
    @Override
    public void setOptionSelected(final OptionsList optionselected) {
        switch (optionselected) {
            case SOUNDON:
                sc.setSoundOn();
                System.out.println(sc.getSoundState());
                break;
            case SOUNDOFF:
                sc.setSoundOff();
                System.out.println(sc.getSoundState());
                break;
            default:
                break;
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SoundsController getSoundController() {
        return this.sc;
    }

}
