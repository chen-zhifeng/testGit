package org.juric.storage.service;

import org.juric.storage.path.EnumRepository;
import org.juric.storage.path.EnumSchema;
import org.juric.storage.path.StoragePath;

import java.io.File;
import java.nio.file.Path;

/**
 * Created with IntelliJ IDEA.
 * User: EricChen
 * Date: 9/21/15
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public interface StorageService {
    public File toFile(StoragePath storagePath);

    public StoragePath generateFilePath(EnumRepository repo,
                                  EnumSchema schema,
                                  Integer logicalShardId,
                                  String ext);
}
