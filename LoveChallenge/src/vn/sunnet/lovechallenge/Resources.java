package vn.sunnet.lovechallenge;

import vn.sunnet.lovechallenge.utils.AnimationCompositeSprite;
import vn.sunnet.lovechallenge.utils.AnimationSprite;
import vn.sunnet.lovechallenge.utils.CompositeSprite;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class Resources {

	private static Resources instance;

	public static Resources getInstance() {
		if (instance == null) {
			instance = new Resources();
		}
		return instance;
	}

	public Resources() {

	}

	public void loadGameScreen(AssetManager manager1, AssetManager manager2) {
		manager1.load("bg/sky.png", Texture.class);
		manager1.load("bg/road.png", Texture.class);
		manager1.load("bg/house.atlas", TextureAtlas.class);
		manager1.load("bg/bghouse.png", Texture.class);

		manager1.load("player/player.atlas", TextureAtlas.class);

		manager1.load("staticobject/staticobjects.atlas", TextureAtlas.class);
	}

	public void unloadGameScreen(AssetManager manager1, AssetManager manager2) {
		manager1.unload("bg/sky.png");
		manager1.unload("bg/road.png");
		manager1.unload("bg/house.atlas");
		manager1.unload("bg/bghouse.png");
		manager1.unload("player/player.atlas");
		manager1.unload("staticobject/staticobjects.atlas");
	}

	public Sprite skySprite;
	public Sprite roadSprite;
	public Sprite house1Sprite;
	public Sprite house2Sprite;
	public Sprite house3Sprite;
	public Sprite house4Sprite;
	public Sprite house5Sprite;
	public Sprite house6Sprite;
	public Sprite house7Sprite;
	public Sprite wall1Sprite;
	public Sprite wall2Sprite;
	public Sprite bghouseSprite;

	public AnimationCompositeSprite player_run_normal;
	public AnimationCompositeSprite player_run_cry;
	public AnimationCompositeSprite player_run_scare;
	public AnimationCompositeSprite player_jump_1;
	public AnimationCompositeSprite player_jump_2;
	public AnimationCompositeSprite player_sit;
	public AnimationCompositeSprite player_die_1;
	public AnimationCompositeSprite player_die_2;

	public Sprite car1Sprite;
	public Sprite car2Sprite;
	public Sprite box1Sprite;
	public Sprite box2Sprite;
	public Sprite static1Sprite;
	public Sprite static2Sprite;
	public Sprite static3Sprite;
	public Sprite static4Sprite;
	public Sprite carlong1Sprite;
	public Sprite carlong2Sprite;
	public Sprite carlong3Sprite;
	public Sprite carlong4Sprite;

	public void getGameScreen(AssetManager manager1, AssetManager manager2) {
		// ============sky=================
		Texture skyTexture = manager1.get("bg/sky.png");
		skyTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		skySprite = new Sprite(skyTexture);
		// ===========road================
		Texture roadTexture = manager1.get("bg/road.png");
		roadTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		roadSprite = new Sprite(roadTexture);
		// ===========house=================
		TextureAtlas houseAtlas = manager1.get("bg/house.atlas");
		house1Sprite = houseAtlas.createSprite("house1");
		house2Sprite = houseAtlas.createSprite("house2");
		house3Sprite = houseAtlas.createSprite("house3");
		house4Sprite = houseAtlas.createSprite("house4");
		house5Sprite = houseAtlas.createSprite("house5");
		house6Sprite = houseAtlas.createSprite("house6");
		house7Sprite = houseAtlas.createSprite("house7");

		wall1Sprite = houseAtlas.createSprite("wall");
		wall2Sprite = houseAtlas.createSprite("wall-2");

		// ==========housebg=================
		Texture bghouseTexture = manager1.get("bg/bghouse.png");
		bghouseTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		bghouseSprite = new Sprite(bghouseTexture);

		TextureAtlas playerAtlas = manager1.get("player/player.atlas");
		// run
		Array<CompositeSprite> player_runFrames = getArrayCompositeSprite(12,
				"run-1", "run-normal", playerAtlas);
		player_run_normal = new AnimationCompositeSprite(
				0.8f / player_runFrames.size, player_runFrames);
		player_run_normal.setPlayMode(AnimationSprite.LOOP);

		Array<CompositeSprite> player_run_cry_Frames = getArrayCompositeSprite(
				12, "run-1", "run-cry", playerAtlas);
		player_run_cry = new AnimationCompositeSprite(
				0.8f / player_run_cry_Frames.size, player_run_cry_Frames);
		player_run_cry.setPlayMode(AnimationSprite.LOOP);

		Array<CompositeSprite> player_run_scare_Frames = getArrayCompositeSprite(
				12, "run-1", "run-scare", playerAtlas);
		player_run_scare = new AnimationCompositeSprite(
				0.8f / player_run_scare_Frames.size, player_run_scare_Frames);
		player_run_scare.setPlayMode(AnimationSprite.LOOP);
		// jump1
		Array<CompositeSprite> player_jump_1_frames = getArrayCompositeSprite(
				11, "jump-1", "jump-1", playerAtlas);
		player_jump_1 = new AnimationCompositeSprite(
				1f / player_jump_1_frames.size, player_jump_1_frames);
		player_jump_1.setPlayMode(AnimationCompositeSprite.NORMAL);
		// jump2
		Array<CompositeSprite> player_jump_2_frames = getArrayCompositeSprite(
				15, "jump-2", "jump-2", playerAtlas);
		player_jump_2 = new AnimationCompositeSprite(
				1f / player_jump_2_frames.size, player_jump_2_frames);
		player_jump_2.setPlayMode(AnimationCompositeSprite.NORMAL);
		// sit
		Array<CompositeSprite> player_sit_frames = getArrayCompositeSprite(13,
				"down", "down", playerAtlas);
		player_sit = new AnimationCompositeSprite(1f / player_sit_frames.size,
				player_sit_frames);
		player_sit.setPlayMode(AnimationCompositeSprite.NORMAL);
		// die 1
		Array<CompositeSprite> player_die_1_frames = getArrayCompositeSprite(
				10, "die-1", "die-1", playerAtlas);
		player_die_1 = new AnimationCompositeSprite(
				1f / player_die_1_frames.size, player_die_1_frames);
		player_die_1.setPlayMode(AnimationCompositeSprite.NORMAL);
		// die 2
		Array<CompositeSprite> player_die_2_frames = getArrayCompositeSprite(
				11, "die-2", "die-2", playerAtlas);
		player_die_2 = new AnimationCompositeSprite(
				1f / player_die_2_frames.size, player_die_2_frames);
		player_die_2.setPlayMode(AnimationCompositeSprite.NORMAL);

		// static
		TextureAtlas staticObjects = manager1
				.get("staticobject/staticobjects.atlas");
		car1Sprite = staticObjects.createSprite("o-to");
		car2Sprite = staticObjects.createSprite("o-to-2");
		box1Sprite = staticObjects.createSprite("box-1");
		box2Sprite = staticObjects.createSprite("box-2");
		static1Sprite = staticObjects.createSprite("vc-1");
		static2Sprite = staticObjects.createSprite("vc-2");
		static3Sprite = staticObjects.createSprite("vc-4");
		static4Sprite = staticObjects.createSprite("vc-5");
		carlong1Sprite = staticObjects.createSprite("car-1");
		carlong2Sprite = staticObjects.createSprite("car-2");
		carlong3Sprite = staticObjects.createSprite("car-3");
		carlong4Sprite = staticObjects.createSprite("car-4");
	}

	public Array<CompositeSprite> getArrayCompositeSprite(int lengFrame,
			String nameBody, String nameHeadState, TextureAtlas atlas) {

		Array<CompositeSprite> frames = new Array<CompositeSprite>();
		for (int i = 0; i < lengFrame; i++) {
			frames.add(new CompositeSprite());
		}
		for (int i = 0; i < frames.size; i++) {
			int index = i + 1;
			String pathBody = "body/" + nameBody + "-(" + index + ")";
			String pathHead = "head/" + nameHeadState + "-(" + index + ")";
			// System.out.println(pathBody + " " + pathhead);
			Sprite body = atlas.createSprite(pathHead);
			Sprite head = atlas.createSprite(pathBody);
			frames.get(i).addComponentSprite(body);
			frames.get(i).addComponentSprite(head);
		}

		return frames;
	}

}
