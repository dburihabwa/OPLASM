package instrumentation;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

/**
 * Classe permettant de modifier le comportement de la méthode compute.
 * 
 * @author dorian
 *
 */
public class Julia extends BugFix {
	public final static Integer MAX_ITER = 570;
	public final static Double ZOOM = 150.0;

	public Julia(ClassWriter writer) {
		super(writer);
	}

	@Override
	/**
	 * Surcharge permettant de modifier le comportement de la méthode compute.
	 */
	public MethodVisitor visitMethod(int access, String name, String desc,
			String signature, String[] exceptions) {
		MethodVisitor methodVisitor = super.visitMethod(access, name, desc,
				signature, exceptions);
		if (name.equalsIgnoreCase("compute")) {
			// FIXME : Modifier le comportement de compute
		}
		return methodVisitor;
	}
}
