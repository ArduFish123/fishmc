package ro.fishmc;

import net.fabric_extras.ranged_weapon.api.CustomBow;
import net.fabric_extras.ranged_weapon.api.RangedConfig;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FishMC implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "fishmc";
    public static final Logger LOGGER = LoggerFactory.getLogger("fishmc");
	public static final Potion DECAY =
			Registry.register(
					Registries.POTION,
					Identifier.of("fishmc", "decay"),
					new Potion(
							new StatusEffectInstance(
									StatusEffects.WITHER,
									3600,
									1)));
	public static final Potion BLINDNESS =
			Registry.register(
					Registries.POTION,
					Identifier.of("fishmc", "blindness"),
					new Potion(
							new StatusEffectInstance(
									StatusEffects.BLINDNESS,
									3600,
									0)));
	public static final Potion GLOWING =
			Registry.register(
					Registries.POTION,
					Identifier.of("fishmc", "glowing"),
					new Potion(
							new StatusEffectInstance(
									StatusEffects.GLOWING,
									800,
									0)));
	public static final Potion LEVITATION =
			Registry.register(
					Registries.POTION,
					Identifier.of("fishmc", "levitation"),
					new Potion(
							new StatusEffectInstance(
									StatusEffects.LEVITATION,
									3600,
									0)));
	public static final Potion STUNNED =
			Registry.register(
					Registries.POTION,
					Identifier.of("fishmc", "stunned"),new Potion(new StatusEffectInstance[]{new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 200), new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 200), new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 400, 200)}));
	public static final Potion SHULKERCRAFT =
			Registry.register(
					Registries.POTION,
					Identifier.of("fishmc", "shulkercraft"),new Potion(new StatusEffectInstance[]{new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 200), new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 2)}));
	public static final Potion CRAFTABLE_DECAY =
			Registry.register(
					Registries.POTION,
					Identifier.of("fishmc", "craftable_decay"),
					new Potion(
							new StatusEffectInstance(
									StatusEffects.WITHER,
									400,
									1)));
	public static final Potion CRAFTABLE_BLINDNESS =
			Registry.register(
					Registries.POTION,
					Identifier.of("fishmc", "craftable_blindness"),
					new Potion(
							new StatusEffectInstance(
									StatusEffects.BLINDNESS,
									400,
									0)));
	public static final Potion CRAFTABLE_GLOWING =
			Registry.register(
					Registries.POTION,
					Identifier.of("fishmc", "craftable_glowing"),
					new Potion(
							new StatusEffectInstance(
									StatusEffects.GLOWING,
									400,
									0)));
	public static final Potion CRAFTABLE_LEVITATION =
			Registry.register(
					Registries.POTION,
					Identifier.of("fishmc", "craftable_levitation"),
					new Potion(
							new StatusEffectInstance(
									StatusEffects.LEVITATION,
									400,
									0)));
	public static final Potion CRAFTABLE_STUNNED =
			Registry.register(
					Registries.POTION,
					Identifier.of("fishmc", "craftable_stunned"),new Potion(new StatusEffectInstance[]{new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 200), new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 200), new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 400, 200)}));
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Welcome to FishMC!");
		var bow = new CustomBow(
				new Item.Settings().maxDamage(150),
				new RangedConfig(3, -0.7F, 5),
				() -> Ingredient.ofItems(Items.OAK_WOOD)
		);
		Registry.register(
				Registries.ITEM,
				Identifier.of(FishMC.MOD_ID, "shortbow"),
				bow
		);
		ModItems.initialize();
		//Registry.registerPotionRecipe(Potions.WATER, Items.POTATO, DECAY);
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(
					// Input potion.
					Potions.AWKWARD,
					// Ingredient
					Items.WITHER_ROSE,
					// Output potion.
					RegistryEntry.of(CRAFTABLE_DECAY)
			);
		});
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(
					// Input potion.
					Potions.AWKWARD,
					// Ingredient
					Items.FERMENTED_SPIDER_EYE,
					// Output potion.
					RegistryEntry.of(CRAFTABLE_BLINDNESS)
			);
		});
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(
					// Input potion.
					Potions.AWKWARD,
					// Ingredient
					Items.GLOW_BERRIES,
					// Output potion.
					RegistryEntry.of(CRAFTABLE_GLOWING)
			);
		});
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(
					// Input potion.
					Potions.AWKWARD,
					// Ingredient
					Items.SHULKER_SHELL,
					// Output potion.
					RegistryEntry.of(CRAFTABLE_LEVITATION)
			);
		});
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(
					// Input potion.
					Potions.AWKWARD,
					// Ingredient
					Items.OMINOUS_BOTTLE,
					// Output potion.
					RegistryEntry.of(CRAFTABLE_STUNNED)
			);
		});
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(
					// Input potion.
					Potions.AWKWARD,
					// Ingredient
					Items.SHULKER_BOX,
					// Output potion.
					RegistryEntry.of(SHULKERCRAFT)
			);
		});
	}
}
