package com.gsc24.spells;

import com.gsc24.mospells.MoreSpells;
import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.AutoSpellConfig;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.Utils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class Pipi extends AbstractSpell{
    private final ResourceLocation spellId = new ResourceLocation(MoreSpells.MODID, "pipi_heal");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getSpellPower(spellLevel, caster), 1))
        );
    }
    public Pipi() {
        this.manaCostPerLevel = 20;
        this.baseSpellPower = 10;
        this.spellPowerPerLevel = 2;
        this.castTime = 1;
        this.baseManaCost = 60;
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.EPIC)
            .setSchoolResource(SchoolRegistry.FIRE_RESOURCE)
            .setMaxLevel(12)
            .setCooldownSeconds(40)
            .build();


    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
    }

    @Override
    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public CastType getCastType() {
        return CastType.LONG;
    }

    @Override
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.empty();
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.empty();
    }



    /*@Override
    public void onCast(Level world, int spellLevel, LivingEntity entity, MagicData playerMagicData) {
        Vec3 origin = entity.getEyePosition();

        MagicFireball fireball = new MagicFireball(world, entity);

        fireball.setDamage(getDamage(spellLevel, entity));
        fireball.setExplosionRadius(getRadius(spellLevel, entity));

        fireball.setPos(origin.add(entity.getForward()).subtract(0, fireball.getBbHeight() / 2, 0));
        fireball.shoot(entity.getLookAngle());

        world.addFreshEntity(fireball);
        super.onCast(world, spellLevel, entity, playerMagicData);
    }
*/
}
