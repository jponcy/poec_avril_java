
package fr.tact.poecjava.courses.jdbc.repository;

import java.util.List;

import fr.tact.poecjava.courses.jdbc.entity.TchuTchu;

/* package */ class TrainRepository implements CrudRepository {

    private static TrainRepository instance;

    private TrainRepository() {
    }

    public List<TchuTchu> findAll() {
        return null;
    }

    public static TrainRepository instance() {
        if (TrainRepository.instance == null) {
            TrainRepository.instance = new TrainRepository();
        }

        return TrainRepository.instance;
    }
}
