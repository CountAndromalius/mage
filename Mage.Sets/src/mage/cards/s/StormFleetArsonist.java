
package mage.cards.s;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.condition.common.RaidCondition;
import mage.abilities.decorator.ConditionalTriggeredAbility;
import mage.abilities.effects.common.SacrificeEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.filter.FilterPermanent;
import mage.target.common.TargetOpponent;
import mage.watchers.common.PlayerAttackedWatcher;

/**
 *
 * @author TheElk801
 */
public final class StormFleetArsonist extends CardImpl {

    public StormFleetArsonist(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{4}{R}");

        this.subtype.add(SubType.ORC);
        this.subtype.add(SubType.PIRATE);
        this.power = new MageInt(4);
        this.toughness = new MageInt(4);

        // Raid - When Storm Fleet Arsonist enters the battlefield, if you attacked with a creature this turn, target opponent sacrifices a permanent.
        Ability ability = new ConditionalTriggeredAbility(
                new EntersBattlefieldTriggeredAbility(new SacrificeEffect(new FilterPermanent(), 1, "Target opponent")),
                RaidCondition.instance,
                "<i>Raid</i> &mdash; When {this} enters the battlefield, if you attacked with a creature this turn, target opponent sacrifices a permanent.");
        ability.addTarget(new TargetOpponent());
        this.addAbility(ability, new PlayerAttackedWatcher());
    }

    public StormFleetArsonist(final StormFleetArsonist card) {
        super(card);
    }

    @Override
    public StormFleetArsonist copy() {
        return new StormFleetArsonist(this);
    }
}
