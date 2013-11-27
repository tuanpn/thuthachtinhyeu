package vn.sunnet.lovechallenge.model.player;

import vn.sunnet.lovechallenge.controller.LoadMap;
import vn.sunnet.lovechallenge.model.player.action.ActionJump1;
import vn.sunnet.lovechallenge.model.player.action.ActionJump2;
import vn.sunnet.lovechallenge.model.player.action.ActionRunCar;
import vn.sunnet.lovechallenge.model.player.action.ActionRunRoad;
import vn.sunnet.lovechallenge.model.player.action.ActionSit;
import vn.sunnet.lovechallenge.model.player.action.ActionStop;
import vn.sunnet.lovechallenge.model.player.action.PlayerActionState;
import vn.sunnet.lovechallenge.model.player.state.CollistionImpedimentState;
import vn.sunnet.lovechallenge.model.player.state.DispiritedState;
import vn.sunnet.lovechallenge.model.player.state.FunnyState;
import vn.sunnet.lovechallenge.model.player.state.PlayerState;
import vn.sunnet.lovechallenge.model.player.state.SadState;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {

	public final int GRAVITY = LoadMap.player_gravity_y;
	public final int VELOCITY_X = LoadMap.player_velocity_x;
	public final int VELOCITY_Y_JUMP = LoadMap.player_velocity_y;
	public final int POSITION_INIT_X = LoadMap.player_position_x;
	public final int POSITION_INIT_Y = LoadMap.player_position_y;
	public final int WIDTH_JUMP = LoadMap.player_width_jump;
	public final int HEIGHT_JUMP = LoadMap.player_height_jump;
	public final int WIDTH_RUN = LoadMap.player_width_run;
	public final int HEIGHT_RUN = LoadMap.player_height_run;
	public final int WIDTH_SIT = LoadMap.player_width_sit;
	public final int HEIGHT_SIT = LoadMap.player_height_sit;
	public final int TIME_SIT = LoadMap.player_time_sit;

	private int id;

	private Vector2 position;
	private Vector2 veloctity;
	private Vector2 accelation;
	private Rectangle bounds;

	private boolean alive;

	private boolean countJump;

	// public enum PlayerActionState {
	// RUN, JUMP, SIT, STOP
	// }
	//
	// private PlayerActionState actionState;

	private PlayerState funnyState;
	private PlayerState dispiritedState;
	private PlayerState sadState;
	private PlayerState tiredState;
	private PlayerState collistionImpedimentState;

	private PlayerState state;

	private PlayerActionState runState;
	private PlayerActionState runOnCarState;
	private PlayerActionState jumpState1;
	private PlayerActionState jumpState2;
	private PlayerActionState sitState;
	private PlayerActionState stopState;
	private float stateTimeSit;
	private float stateTimeRun;
	private float stateTimeJump1;
	private float stateTimeDie;
	private float stateTimeRunCar;

	private PlayerActionState actionState;

	/**
	 * phần trăm thanh trạng thái
	 */
	private int percentageStateBar = 100;

	private boolean flingUp;
	private boolean flingDown;

	private int colistionState;

	/*
	 * dừng hình,không cập nhật chạy
	 */
	private boolean stopUpdate;

	public Player(int id) {
		this.id = id;

		position = new Vector2(POSITION_INIT_X, POSITION_INIT_Y);
		veloctity = new Vector2(0, 0);
		accelation = new Vector2(0, 0);
		bounds = new Rectangle(POSITION_INIT_X, POSITION_INIT_Y, WIDTH_RUN,
				HEIGHT_RUN);

		funnyState = new FunnyState(this);
		dispiritedState = new DispiritedState(this);
		sadState = new SadState(this);
		tiredState = new SadState(this);
		collistionImpedimentState = new CollistionImpedimentState(this);

		state = funnyState;

		setRunState(new ActionRunRoad(this));
		setRunOnCarState(new ActionRunCar(this));
		setJumpState1(new ActionJump1(this));
		setJumpState2(new ActionJump2(this));
		setSitState(new ActionSit(this));
		setStopState(new ActionStop(this));

		actionState = runState;

		stateTimeSit = 0;
		stateTimeRun = 0;
		stateTimeJump1 = 0;
		setStateTimeRunCar(0);
		flingUp = false;
		flingDown = false;
		stateTimeDie = 0;
		stopUpdate = false;
	}

	public void flingup() {
		this.actionState.flingup();
	}

	public void flingdown() {
		this.actionState.flingdown();
	}

	public void collistionImpedimet(float delta) {
		this.actionState.collistionImpedimet(delta);
	}

	public void idleRun(float delta) {
		this.actionState.idleRun(delta);
	}

	public void collistionImpediment(int type) {
		this.state.collistionImpediment(type);
	}

	public void increaseStateBar90() {
		this.state.increaseStateBar90();
	}

	public void increaseStateBar80() {
		this.state.increaseStateBar80();
	}

	public void increaseStateBar70() {
		this.state.increaseStateBar70();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Vector2 getVeloctity() {
		return veloctity;
	}

	public void setVeloctity(Vector2 veloctity) {
		this.veloctity = veloctity;
	}

	public boolean isCountJump() {
		return countJump;
	}

	public void setCountJump(boolean countJump) {
		this.countJump = countJump;
	}

	public PlayerActionState getRunState() {
		return runState;
	}

	public void setRunState(PlayerActionState runState) {
		this.runState = runState;
	}

	public PlayerActionState getActionState() {
		return actionState;
	}

	public void setActionState(PlayerActionState actionState) {
		this.actionState = actionState;
	}

	public Vector2 getAccelation() {
		return accelation;
	}

	public void setAccelation(Vector2 accelation) {
		this.accelation = accelation;
	}

	public boolean isFlingUp() {
		return flingUp;
	}

	public void setFlingUp(boolean flingUp) {
		this.flingUp = flingUp;
	}

	public PlayerActionState getJumpState1() {
		return jumpState1;
	}

	public void setJumpState1(PlayerActionState jumpState1) {
		this.jumpState1 = jumpState1;
	}

	public PlayerActionState getJumpState2() {
		return jumpState2;
	}

	public void setJumpState2(PlayerActionState jumpState2) {
		this.jumpState2 = jumpState2;
	}

	public float getStateTimeDie() {
		return stateTimeDie;
	}

	public void setStateTimeDie(float stateTimeDie) {
		this.stateTimeDie = stateTimeDie;
	}

	public PlayerActionState getStopState() {
		return stopState;
	}

	public void setStopState(PlayerActionState stopState) {
		this.stopState = stopState;
	}

	public PlayerActionState getRunOnCarState() {
		return runOnCarState;
	}

	public void setRunOnCarState(PlayerActionState runOnCarState) {
		this.runOnCarState = runOnCarState;
	}

	public boolean isFlingDown() {
		return flingDown;
	}

	public void setFlingDown(boolean flingDown) {
		this.flingDown = flingDown;
	}

	public PlayerActionState getSitState() {
		return sitState;
	}

	public void setSitState(PlayerActionState sitState) {
		this.sitState = sitState;
	}

	public float getStateTimeSit() {
		return stateTimeSit;
	}

	public void setStateTimeSit(float stateTimeSit) {
		this.stateTimeSit = stateTimeSit;
	}

	public float getStateTimeRun() {
		return stateTimeRun;
	}

	public void setStateTimeRun(float stateTimeRun) {
		this.stateTimeRun = stateTimeRun;
	}

	public float getStateTimeJump1() {
		return stateTimeJump1;
	}

	public void setStateTimeJump1(float stateTimeJump1) {
		this.stateTimeJump1 = stateTimeJump1;
	}

	public float getStateTimeRunCar() {
		return stateTimeRunCar;
	}

	public void setStateTimeRunCar(float stateTimeRunCar) {
		this.stateTimeRunCar = stateTimeRunCar;
	}

	public int getPercentageStateBar() {
		return percentageStateBar;
	}

	public void setPercentageStateBar(int percentageStateBar) {
		this.percentageStateBar = percentageStateBar;
	}

	public int getColistionState() {
		return colistionState;
	}

	/**
	 * 
	 * @param colistionState
	 *            0 : không có va chạm; 1 : va chạm với static bình thường; 2 :
	 *            va chạm với car long
	 * 
	 */
	public void setColistionState(int colistionState) {
		this.colistionState = colistionState;
	}

	public boolean isStopUpdate() {
		return stopUpdate;
	}

	public void setStopUpdate(boolean stopUpdate) {
		this.stopUpdate = stopUpdate;
	}

	public void update(float delta) {
		switch (actionState.getID()) {
		case 0:
			stateTimeRun += delta;
			break;
		case 1:
			stateTimeJump1 += delta;
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			stateTimeRunCar += delta;
			break;

		default:
			break;
		}

		// position
		veloctity.add(accelation.x * delta, accelation.y * delta);
		position.add(veloctity.x * delta, veloctity.y * delta);

		switch (actionState.getID()) {
		case 0:
			bounds.x = position.x + 40;
			bounds.y = position.y;
			break;
		case 1:
			bounds.x = position.x + 40;
			bounds.y = position.y + 60;
			break;
		case 2:
			bounds.x = position.x + 20;
			bounds.y = position.y;
			break;
		case 4:
			bounds.x = position.x + 40;
			bounds.y = position.y;
			break;

		default:
			break;
		}

	}

	public void resetAll() {
		initStateRun();
		setStateTimeDie(0);
		setStateTimeJump1(0);
		setStateTimeRunCar(0);
	}

	public void initStateRun() {
		setColistionState(0);
		setStateTimeRun(0);
		setActionState(runState);
		getBounds().width = WIDTH_RUN;
		getBounds().height = HEIGHT_RUN;
		getAccelation().y = 0;
		getVeloctity().y = 0;
		getPosition().y = POSITION_INIT_Y;
		setStopUpdate(false);
	}

}
