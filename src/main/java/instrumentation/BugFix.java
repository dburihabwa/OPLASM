package instrumentation;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

/**
 * ClassVisitor changeant la valeur de la constante utilisé dans la formule de
 * calcul des ensembles de Mandelbrot.
 * 
 * @author dorian
 *
 */
public class BugFix extends ParameterAdapter {

	public BugFix(ClassWriter writer) {
		super(writer);
	}

	@Override
	/**
	 * Surcharge permettant de modifier le comportement de la fonction nextY. 
	 */
	public MethodVisitor visitMethod(int access, String name, String desc,
			String signature, String[] exceptions) {
		MethodVisitor methodVisitor = super.visitMethod(access, name, desc,
				signature, exceptions);
		if (name.equalsIgnoreCase("nextY")) {
			methodVisitor = new BugFixMethodVisitor(methodVisitor);
		}

		return methodVisitor;
	}
}
