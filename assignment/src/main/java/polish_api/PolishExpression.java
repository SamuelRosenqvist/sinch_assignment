package polish_api;

import problems.Problem2;

import java.util.Objects;
import java.util.Stack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class PolishExpression {

    private @Id @GeneratedValue Long id;
    private String expr;
    private String result;

    PolishExpression() {}

    PolishExpression(String expr) {

        this.expr = expr;
        this.result = makeResult(expr);
    }

    public Long getId() {
        return this.id;
    }

    public String getExpr() {
        return this.expr;
    }

    public String getResult() {
        return this.result;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public void setResult(String result){
        this.result = evaluateExpression(this.expr);
    }

    public static String makeResult(String expr){
        return evaluateExpression(expr);
    }

    private static String evaluateExpression(String expr){
        Problem2 p2 = new Problem2();
        Stack<String> stack = p2.make_stack(expr);
        return p2.evaluate(stack);
    }


    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof PolishExpression))
            return false;
        PolishExpression polishExpression = (PolishExpression) o;
        return Objects.equals(this.id, polishExpression.id) && Objects.equals(this.expr, polishExpression.expr)
                && Objects.equals(this.result, polishExpression.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.expr, this.result);
    }

    @Override
    public String toString() {
        return "Polish expression{" + "id=" + this.id + ", expression='" + this.expr + '\'' + ", result='" + this.result + '\'' + '}';
    }
}