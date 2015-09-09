package ast;

public class DeclarationSequence extends Declaration {
	Declaration d1;
	Declaration d2;
	
	public DeclarationSequence(Declaration d1, Declaration d2) {
		this.d1 = d1;
		this.d2 = d2;
	}
}
