package web.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import web.app.entity.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, String> {
}
