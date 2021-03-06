
package mage.cards.s;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.InfoEffect;
import mage.abilities.effects.common.continuous.BoostControlledEffect;
import mage.abilities.effects.common.continuous.GainAbilityControlledEffect;
import mage.abilities.keyword.HasteAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.filter.common.FilterCreaturePermanent;
import static mage.filter.predicate.permanent.ControllerControlsIslandPredicate.filter;

/**
 *
 * @author LevelX2
 */
public final class SteamfloggerBoss extends CardImpl {

    public SteamfloggerBoss(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{3}{R}");

        this.subtype.add(SubType.GOBLIN);
        this.subtype.add(SubType.RIGGER);
        this.power = new MageInt(3);
        this.toughness = new MageInt(3);

        // Other Rigger creatures you control get +1/+0 and have haste.
        Ability ability = new SimpleStaticAbility(Zone.BATTLEFIELD,
                new BoostControlledEffect(1, 0, Duration.WhileOnBattlefield, new FilterCreaturePermanent(SubType.RIGGER, "Rigger creatures"), true));
        Effect effect = new GainAbilityControlledEffect(HasteAbility.getInstance(), Duration.WhileOnBattlefield, filter);
        effect.setText("and have haste");
        ability.addEffect(effect);
        this.addAbility(ability);

        // If a Rigger you control would assemble a Contraption, it assembles two Contraptions instead.
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new InfoEffect("If a Rigger you control would assemble a Contraption, it assembles two Contraptions instead. (NOT IMPLEMENTED)")));

    }

    public SteamfloggerBoss(final SteamfloggerBoss card) {
        super(card);
    }

    @Override
    public SteamfloggerBoss copy() {
        return new SteamfloggerBoss(this);
    }
}
