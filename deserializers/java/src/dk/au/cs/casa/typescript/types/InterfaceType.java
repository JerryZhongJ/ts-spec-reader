package dk.au.cs.casa.typescript.types;

import java.util.List;
import java.util.Map;

/*
 * Read https://www.typescriptlang.org/docs/handbook/2/objects.html
 */
public class InterfaceType implements Type {
    private List<Type> typeParameters;
    private List<Type> baseTypes;
    private Map<String, Type> declaredProperties;
    private List<String> readonlyDeclarations;
    private List<Signature> declaredCallSignatures;
    private List<Signature> declaredConstructSignatures;
    private Type declaredStringIndexType;
    private Type declaredNumberIndexType;

    public Type getDeclaredNumberIndexType() {
        return declaredNumberIndexType;
    }

    public void setDeclaredNumberIndexType(Type declaredNumberIndexType) {
        this.declaredNumberIndexType = declaredNumberIndexType;
    }

    public Type getDeclaredStringIndexType() {

        return declaredStringIndexType;
    }

    public void setDeclaredStringIndexType(Type declaredStringIndexType) {
        this.declaredStringIndexType = declaredStringIndexType;
    }

    public List<Signature> getDeclaredConstructSignatures() {
        return declaredConstructSignatures;
    }

    public void setDeclaredConstructSignatures(List<Signature> declaredConstructSignatures) {
        this.declaredConstructSignatures = declaredConstructSignatures;
    }

    public List<String> getReadonlyDeclarations() {
        return readonlyDeclarations;
    }

    public void setReadonlyDeclarations(List<String> readonlyDeclarations) {
        this.readonlyDeclarations = readonlyDeclarations;
    }

    public List<Signature> getDeclaredCallSignatures() {
        return declaredCallSignatures;
    }

    public void setDeclaredCallSignatures(List<Signature> declaredCallSignatures) {
        this.declaredCallSignatures = declaredCallSignatures;
    }

    public Map<String, Type> getDeclaredProperties() {
        return declaredProperties;
    }

    public void setDeclaredProperties(Map<String, Type> declaredProperties) {
        this.declaredProperties = declaredProperties;
    }

    public List<Type> getBaseTypes() {
        return baseTypes;
    }

    public void setBaseTypes(List<Type> baseTypes) {
        this.baseTypes = baseTypes;
    }

    public List<Type> getTypeParameters() {
        return typeParameters;
    }

    public void setTypeParameters(List<Type> typeParameters) {
        this.typeParameters = typeParameters;
    }

    @Override
    public String toString() {
        return "Interface(" + declaredProperties.keySet() + ")";
    }

    @Override
    public <T> T accept(TypeVisitor<T> v) {
        return v.visit(this);
    }
    @Override
    public <T, A> T accept(TypeVisitorWithArgument<T, A> v, A a) {
        return v.visit(this, a);
    }

}
