
package mage.cards.q;

import java.util.UUID;
import mage.MageInt;
import mage.MageObject;
import mage.abilities.Ability;
import mage.abilities.common.EntersBattlefieldAbility;
import mage.abilities.effects.common.CopyPermanentEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.util.functions.ApplyToPermanent;

/**
 * @author ayratn
 */
public final class QuicksilverGargantuan extends CardImpl {

    public QuicksilverGargantuan(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{5}{U}{U}");
        this.subtype.add(SubType.SHAPESHIFTER);

        this.power = new MageInt(7);
        this.toughness = new MageInt(7);

        Ability ability = new EntersBattlefieldAbility(new CopyPermanentEffect(new QuicksilverGargantuanApplyToPermanent()),
                "You may have {this} enter the battlefield as a copy of any creature on the battlefield, except it's still 7/7");
        this.addAbility(ability);
    }

    public QuicksilverGargantuan(final QuicksilverGargantuan card) {
        super(card);
    }

    @Override
    public QuicksilverGargantuan copy() {
        return new QuicksilverGargantuan(this);
    }
}

class QuicksilverGargantuanApplyToPermanent extends ApplyToPermanent {

    @Override
    public boolean apply(Game game, Permanent permanent, Ability source, UUID copyToObjectId) {
        permanent.removePTCDA();
        permanent.getPower().modifyBaseValue(7);
        permanent.getToughness().modifyBaseValue(7);
        return true;
    }

    @Override
    public boolean apply(Game game, MageObject mageObject, Ability source, UUID copyToObjectId) {
        mageObject.removePTCDA();
        mageObject.getPower().modifyBaseValue(7);
        mageObject.getToughness().modifyBaseValue(7);
        return true;
    }

}
