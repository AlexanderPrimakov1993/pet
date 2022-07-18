package com.dailycodebuffer.springbootfileupload.repository;

import com.dailycodebuffer.springbootfileupload.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, String> {
}
