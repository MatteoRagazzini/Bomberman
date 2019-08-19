package it.unibo.bmbman.controller;
/**
 * Class that manage the behaviour of the options menù.
 */
public class OptionMenuControllerImpl implements OptionsMenuController {
    private final SoundsController sc = new SoundsController();
    /**
     * {@inheritDoc}
     */
    @Override
    public void setOptionSelected(final OptionsMenuList optionselected) {
        switch (optionselected) {
            case MUSICON:
                sc.setMusicdOn();
                break;
            case MUSICOFF:
                sc.setMusicOff();
                break;
            case EFFECTON:
                sc.setEffectsOn();
                break;
            case EFFECTOFF:
                sc.setEffectsOff();
                break;
            default:
                break;
        }
        this.sc.setSounds();
    }
}
