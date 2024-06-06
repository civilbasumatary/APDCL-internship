package com.example.eoffice;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
    List<FileEntity> findByOffice(Office office);
}
