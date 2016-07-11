package i5.las2peer.services.recommender.librec.ext;

import i5.las2peer.services.recommender.librec.data.SparseMatrix;
import i5.las2peer.services.recommender.librec.intf.Recommender;

/**
 * <p>
 * Suppose that you have some predictive ratings (in "pred.txt") generated by an external recommender (e.g., some
 * recommender of MyMediaLite). The predictions are in the format of user-item-prediction. These predictions are
 * corresponding to a test set "test.txt" (user-item-held_out_rating). This class (ExternalRecommender) provides you
 * with the ability to compute predictive performance by setting the training set as "pred.txt" and the test set as
 * "test.txt". <br>
 * <br>
 * 
 * <strong>NOTE:</strong> This approach is not applicable to item recommendation. Thank {@literal Marcel Ackermann} for
 * bringing this demand to my attention.
 * </p>
 * 
 * @author Guo Guibing
 *
 */
public class External extends Recommender {

	public External(SparseMatrix trainMatrix, SparseMatrix testMatrix, int fold) {
		super(trainMatrix, testMatrix, fold);

		isRankingPred = false; // not applicable to item recommendation
	}

	@Override
	protected double predict(int u, int j, boolean bound) throws Exception {
		return trainMatrix.get(u, j);
	}

}
