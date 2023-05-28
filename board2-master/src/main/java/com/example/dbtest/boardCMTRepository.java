package com.example.dbtest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface boardCMTRepository extends JpaRepository<boardCMT, Integer> {


    List<boardCMT> findByBoardId(int boardId);

    List<boardCMT> findByBoardIdOrderByCmtTimeDesc(int boardId);

}
