package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

public class Remark {
    public static final String MESSAGE_CONSTRAINTS = "Remark has no constrains";

    public final String value;

    /**
     * Constructs an {@code Address}.
     *
     * @param remark A remark.
     */
    public Remark(String remark) {
        requireNonNull(remark);

        value = remark;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
