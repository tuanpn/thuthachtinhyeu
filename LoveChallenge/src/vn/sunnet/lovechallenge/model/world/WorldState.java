package vn.sunnet.lovechallenge.model.world;

public interface WorldState {

	/**
	 * Chuyển sang ready
	 */
	public void onReady();

	/**
	 * Chuyển sang running
	 */
	public void onRunning();

	/**
	 * Chuyển sang pause
	 */
	public void onPause();

	/**
	 * chuyển sang levelend (chiến thắng màn)
	 */
	public void onLevelend();

	/**
	 * chuyển sang over (thua màn)
	 */
	public void onOver();
}
