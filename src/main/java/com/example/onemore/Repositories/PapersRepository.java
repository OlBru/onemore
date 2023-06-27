    package com.example.onemore.Repositories;

    import com.example.onemore.models.issuer;
    import com.example.onemore.models.papers;
    import org.springframework.data.repository.CrudRepository;

    public interface PapersRepository extends CrudRepository<papers, Integer> {

        papers save(papers papers);
        void delete(papers papers);
        void deleteById(Integer id);
    }
