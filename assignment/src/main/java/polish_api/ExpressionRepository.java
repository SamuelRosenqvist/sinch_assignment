package polish_api;

import org.springframework.data.jpa.repository.JpaRepository;

interface ExpressionRepository extends JpaRepository<PolishExpression, Long> {

}