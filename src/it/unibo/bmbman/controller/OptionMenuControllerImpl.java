package it.unibo.bmbman.controller;
/**
 * implementation of OptionMenuController interface.
 */
public class OptionMenuControllerImpl implements OptionsMenuController {
    private final SoundsController sc = new SoundsController();
    /**
     * .
     */
    @Override
    public void setOptionSelected(final OptionsList optionselected) {
        switch (optionselected) {
            case SOUNDON:
                sc.SetSoundOn();
                System.out.println(sc.getSoundState());
                break;
            case SOUNDOFF:
                sc.SetSoundOff();
                System.out.println(sc.getSoundState());
                break;
            default:
                break;
        }

    }

}
