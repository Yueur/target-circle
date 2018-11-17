package targetcircle.output;

import targetcircle.core.IElement;
import targetcircle.core.GiverTaker;

/**
 * 
 * Syntax
 * ```
 *  digraph graphname {
 * 		a -> b -> c;
 *  	b -> d;
 *  }
 * ```
 *
 */
public class ToDotV implements IOutput {
	public void output(GiverTaker<IElement, IElement> bbb){
		System.out.println(bbb);
	}
}
