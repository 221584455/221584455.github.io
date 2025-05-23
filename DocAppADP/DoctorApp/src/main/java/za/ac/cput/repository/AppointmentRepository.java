package za.ac.cput.repository;

import za.ac.cput.domain.Appointment;

import java.util.List;
import java.util.Optional;

public class AppointmentRepository implements IRepository<Appointment> {

    private List<Appointment> appointments;

    @Override
    public Appointment create(Appointment appointment) {
        appointments.add(appointment);
        return appointment;
    }

    @Override
    public Optional<Appointment> read(int appointmentID) {
        return appointments.stream()
                .filter(appointment -> appointment.getAppointmentID() == appointmentID)
                .findFirst();    }

    @Override
    public Appointment update(Appointment appointment) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getAppointmentID() == appointment.getAppointmentID()) {
                appointments.set(i, appointment);
                return appointment;
            }
        }
        return null;    }

    @Override
    public boolean delete(int appointmentID) {
        return appointments.removeIf(appointment -> appointment.getAppointmentID() == appointmentID);
    }

    @Override
    public List<Appointment> findAll() {
        return appointments;
    }
}
