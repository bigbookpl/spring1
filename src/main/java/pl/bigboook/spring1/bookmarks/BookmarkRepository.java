package pl.bigboook.spring1.bookmarks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long>{

    Collection<Bookmark> findByAccountUsername(String username);
}
